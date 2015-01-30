define(
		[ 'backbone', 'resthub', 'hbs!template/home', 'view/news-view', 'view/introSlider-view', 'collection/notizia-collection', 'model/gruppofoto' ],
		function(Backbone, Resthub, homeTemplate, NewsView, IntroSliderView, NotiziaCollection, GruppoFotoModel) {

			
			var HomeView = Resthub.View
					.extend({

						// Define view template
						template : homeTemplate,
						

						events : {
							"click #button1" : function() {
						        var newsView = new NewsView({
						            collection: NotiziaCollection,
						            root: this.$('#news'),
						            anno : "2015",
						            mese : "09"
						        })
							},
							"click #button2" : function() {
						        var newsView = new NewsView({
						            collection: NotiziaCollection,
						            root: this.$('#news')
						        })
							}
						},
						
						initialize : function() {
							
							this.model = new GruppoFotoModel({
								url : "gruppofoto/azienda"
							});
							
							var self = this;
							this.model.fetch({
								success : function(intro){
									self.model = intro;
									self.render(self);
								}
							});
							
							// Render the view
							this.render();
						},

						render : function() {		
							HomeView.__super__.render.apply(this, arguments);
							
					        var introSliderView = new IntroSliderView({
								root : $('#introSlider'), 
								idGruppo : this.model.id
					            })	
							
							//Inserimento delle nested views
					        var newsView = new NewsView({
					            collection: NotiziaCollection,
					            root: this.$('#news')})
						},
					});
		return HomeView;
		});