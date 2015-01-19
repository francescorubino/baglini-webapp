define(['backbone', 'model/articolo'], function (Backbone, Commento) {

    var Commenti = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: Commento,
        url:'articolo/commenti',
        initialize: function(args){
        	if(typeof args.id !== 'undefine'){
        		this.url = this.url + "?idArticolo=" + args.id;
        	}
        },

    });
    return Commenti;
});
