define([ 'backbone', 'resthub', 'i18n!nls/labels', 'view/gruppoFoto-view', 'hbs!template/realizzazioni' ],
		function(Backbone, Resthub, myLabels, GruppoFotoView, realizzazioniTemplate) {

			var RealizzazioniView = Resthub.View.extend({

				// Define view template
				template : realizzazioniTemplate,
				labels : myLabels,

				initialize : function() {
					this.render();
				},

				render : function() {
					RealizzazioniView.__super__.render.apply(this, arguments);
					
					new GruppoFotoView({
						root : $('#realizzazioni'), 
						nomeSezione : 'realizzazioni'
					});
				},

			});
			return RealizzazioniView;
		});