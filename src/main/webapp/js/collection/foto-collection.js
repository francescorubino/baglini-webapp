define(['backbone', 'model/foto'], function (Backbone, FotoModel) {

    var FotoCollection = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: FotoModel,
        url:'foto/list',
        
        initialize: function(args){
        	if(typeof args.idGruppo != 'undefined'){
        		this.url = 'foto/findByGroup?idGruppo=' + args.idGruppo;
        	}
        	if(typeof args.nome != 'undefined'){
        		this.url = 'foto/findByName?nome=' + args.nome;
        	}
        },

    });
    return FotoCollection;
});
