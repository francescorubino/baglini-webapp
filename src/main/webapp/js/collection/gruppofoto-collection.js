define(['backbone', 'model/gruppofoto'], function (Backbone, GruppoFotoModel) {

    var GruppoFotoCollection = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: GruppoFotoModel,
        url:'gruppofoto/list',
        
        initialize: function(args){
        	if(typeof args.nomeSezione != 'undefined'){
        		this.url = 'gruppofoto/gruppoBySezione?nomeSezione=' + args.nomeSezione;
        	}
        	if(typeof args.idGruppo != 'undefined'){
        		this.url = 'gruppofoto/findByGroup?idGruppo=' + args.idGruppo;
        	}
        	if(typeof args.nome != 'undefined'){
        		this.url = 'gruppofoto/gruppoByNome?nome=' + args.nome;
        	}
        },

    });
    return GruppoFotoCollection;
});
