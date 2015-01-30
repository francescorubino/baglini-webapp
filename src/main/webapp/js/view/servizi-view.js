define([ 'backbone', 'resthub', 'i18n!nls/labels', 'jssor-slider', 'view/slider-view', 'model/gruppofoto', 'hbs!template/servizi' ],
		function(Backbone, Resthub, myLabels, JssorSlider, SliderView, GruppoFotoModel, serviziTemplate) {

			var ServiziView = Resthub.View.extend({

				// Define view template
				template : serviziTemplate,
				labels : myLabels,
				
				initialize : function() {

					this.model = new GruppoFotoModel({
						url : "gruppofoto/servizi"
					});
					
					var self = this;
					this.model.fetch({
						success : function(azienda){
							self.model = azienda;
							self.render(self);
						}
					});
				},

				render : function() {
					ServiziView.__super__.render.apply(this, arguments);
					new SliderView({
						root : $('#slider'), 
						idGruppo : this.model.id
					});
				},

			});
			return ServiziView;
		});