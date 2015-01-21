define(['backbone', 'model/gruppofoto'], function (Backbone, FotoModel) {

    var FotoCollection = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: FotoModel,
        url:'gruppofoto/list',
        
        initialize: function(args){
        	if(typeof args.idGruppo != 'undefined'){
        		this.url = 'gruppofoto/findByGroup?idGruppo=' + args.idGruppo;
        	}
        	if(typeof args.nome != 'undefined'){
        		this.url = 'gruppofoto/gruppoByNome?nome=' + args.nome;
        	}
        },

    });
    return FotoCollection;
});
