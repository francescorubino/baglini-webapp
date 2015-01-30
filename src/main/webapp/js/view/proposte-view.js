define([ 'backbone', 'resthub', 'i18n!nls/labels', 'view/gruppoFoto-view', 'hbs!template/proposte' ],
		function(Backbone, Resthub, myLabels, GruppoFotoView, proposteTemplate) {

			var ProposteView = Resthub.View.extend({

				// Define view template
				template : proposteTemplate,
				labels : myLabels,

				initialize : function() {
					this.render();
				},

				render : function() {
					ProposteView.__super__.render.apply(this, arguments);
					
					new GruppoFotoView({
						root : $('#proposte'), 
						nomeSezione : 'proposte'
					});
				},

			});
			return ProposteView;
		});