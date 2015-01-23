define([ 'backbone', 'model/notizia' ], function(Backbone, NotiziaModel) {

	var NotiziaCollection = Backbone.Collection.extend({

		// Reference to this collection's model.
		model : NotiziaModel,
		url : 'notizia/list',

		initialize : function(args) {
			if (typeof args != 'undefined') {
				if (typeof args.anno != 'undefined'
						&& typeof args.mese == 'undefined') {
					this.url = 'notizia/findByAnno?anno=' + args.anno;
				}

				if (typeof args.anno != 'undefined'
						&& typeof args.mese != 'undefined') {
					this.url = 'notizia/findByAnnoAndMese?anno=' + args.anno
							+ '&mese=' + args.mese;
				}

			}
		},

	});
	return NotiziaCollection;
});
