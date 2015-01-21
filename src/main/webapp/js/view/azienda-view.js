define([ 'backbone', 'resthub', 'jssor-slider', 'view/slider-view', 'hbs!template/azienda' ],
		function(Backbone, Resthub, JssorSlider, SliderView, aziendaTemplate) {

			var AziendaView = Resthub.View.extend({

				// Define view template
				template : aziendaTemplate,

				initialize : function() {

					// Render the view
					this.render();
				},

				render : function() {
					AziendaView.__super__.render.apply(this, arguments);
					new SliderView({
						root : $('#slider')
					});
				},

			});
			return AziendaView;
		});