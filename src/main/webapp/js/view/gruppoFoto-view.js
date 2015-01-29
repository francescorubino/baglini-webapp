define([ 'backbone', 'resthub', 'collection/gruppofoto-collection',
		'hbs!template/gruppoFoto', 'view/paginator-view' ], function(Backbone, Resthub,
		GruppoFotoCollection, gruppoFotoTemplate, PaginatorView) {

	var GruppoFotoView = Resthub.View.extend({

		// Define view template
		template : gruppoFotoTemplate,

		events : {
			"click .paginator" : function(e) {
				this.collection.goTo($(e.currentTarget).data('page'));
			}
		// events to change page
		},

		initialize : function(args) {
			// Initialize the collection
			this.collection = new GruppoFotoCollection({
				nomeSezione : args.nomeSezione
			});

			// Render the view when the collection is retrieved from the server
			this.listenTo(this.collection, 'sync', this.render);
			
			// Render the view when the page is changed
			this.listenTo(this.collection, 'reset', this.render);

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

	});
	return GruppoFotoView;
});