define([ 'backbone', 'resthub', 'collection/gruppofoto-collection',
		'hbs!template/gruppoFoto', 'view/paginator-view', 'view/slider-view',
		'colorbox' ], function(Backbone, Resthub, GruppoFotoCollection,
		gruppoFotoTemplate, PaginatorView, SliderView) {

	var GruppoFotoView = Resthub.View.extend({

		// Define view template
		template : gruppoFotoTemplate,

		events : {
			"click .paginatorPrevious" : function(e) {
				this.collection.prevPage();
			},
			"click .paginatorPage" : function(e) {
				this.collection.goTo($(e.currentTarget).data('page'));
			},
			"click .paginatorNext" : function(e) {
				this.collection.nextPage();
			},
			"click .colorbox" : function(e) {
				var sliderView = new SliderView({
					root : ($('#overlay')),
					idGruppo : $(e.currentTarget).data('idgruppo')
				});
				$.colorbox({
					html : sliderView.el,
					title: $(e.currentTarget).data('title'),
					width : "650px",
					height: "520px",
					scrolling: false
				});

			}

		},

		initialize : function(args) {
			// Initialize the collection
			this.collection = new GruppoFotoCollection({
				nomeSezione : args.nomeSezione
			});

			// Render the view when the collection is retrieved from the server
			this.listenTo(this.collection, 'sync', this.render);

			// Render the view when the page is changed
			this.listenTo(this.collection, 'reset', this.update);

			// Request first page
			this.collection.fetch({
				success : function() {
					this.collection.goTo(1);
				}.bind(this),
				error : function(collection, response) {
					console.log(collection);
					console.log(response);
				}
			});
		},

		render : function() {
			GruppoFotoView.__super__.render.apply(this, arguments);

			new PaginatorView({
				root : $('#paginator'),
				totalPages : this.collection.info().totalPages,
				currentPage : this.collection.info().currentPage
			});
			
			
		},
		
		update : function() {
		    
		    this.render();
		}

	});
	return GruppoFotoView;
});