define([ 'backbone', 'resthub', 'jssor-slider', 'view/slider-view', 'hbs!template/servizi' ],
		function(Backbone, Resthub, JssorSlider, SliderView, serviziTemplate) {

			var ServiziView = Resthub.View.extend({

				// Define view template
				template : serviziTemplate,

				initialize : function() {

					// Render the view
					this.render();
				},

				render : function() {
					ServiziView.__super__.render.apply(this, arguments);
					new SliderView({
						root : $('#slider')
					});
				},

			});
			return ServiziView;
		});