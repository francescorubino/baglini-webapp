define([ 'backbone', 'resthub', 'jssor-slider', 'i18n!nls/labels', 'view/slider-view', 'model/gruppofoto', 'hbs!template/azienda' ],
		function(Backbone, Resthub, JssorSlider, myLabels, SliderView, GruppoFotoModel, aziendaTemplate) {

			var AziendaView = Resthub.View.extend({

				// Define view template
				template : aziendaTemplate,
				labels : myLabels,

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