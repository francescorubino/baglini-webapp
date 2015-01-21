define([ 'backbone', 'resthub', 'jssor-slider', 'view/slider-view', 'model/gruppofoto', 'hbs!template/azienda' ],
		function(Backbone, Resthub, JssorSlider, SliderView, GruppoFotoModel, aziendaTemplate) {

			var AziendaView = Resthub.View.extend({

				// Define view template
				template : aziendaTemplate,

				initialize : function() {

					this.model = new GruppoFotoModel({
						url : "gruppofoto/azienda"
					});
					
					var self = this;
					this.model.fetch({
						success : function(azienda){
							self.model = azienda;
							self.render(self);
						}
					});
					// Render the view
				},

				render : function() {
					AziendaView.__super__.render.apply(this, arguments);
					new SliderView({
						root : $('#slider'), 
						idGruppo : this.model.id
					});
				},

			});
			return AziendaView;
		});