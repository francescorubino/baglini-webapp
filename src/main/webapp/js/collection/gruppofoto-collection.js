define(['backbone-paginator', 'model/gruppofoto'], function (Paginator, GruppoFotoModel) {

    var GruppoFotoCollection = Backbone.Paginator.clientPager.extend({

        // Reference to this collection's model.
        model: GruppoFotoModel,
        url:'gruppofoto/list',
        paginator_core:{
            // the type of the request (GET by default)
            type:'GET',

            // the type of reply (json by default)
            dataType:'json',

            // the URL (or base URL) for the service
            url:'gruppofoto/list',
        },
        paginator_ui:{
            // the lowest page index your API allows to be accessed
            firstPage:1,

            // which page should the paginator start from
            // (also, the actual page the paginator is on)
            currentPage:1,

            // how many items per page should be shown
            perPage:4,

            // a default number of total pages to query in case the API or
            // service you are using does not support providing the total
            // number of pages for us.
            // 10 as a default in case your service doesn't return the total
            totalPages:10
        },
        parse:function (response) {
            return response;
        },
        
        initialize: function(args){
        	if(typeof args.nomeSezione != 'undefined'){
        		this.paginator_core.url = 'gruppofoto/gruppoBySezione?nomeSezione=' + args.nomeSezione;
        	}
        	if(typeof args.idGruppo != 'undefined'){
        		this.paginator_core.url = 'gruppofoto/findByGroup?idGruppo=' + args.idGruppo;
        	}
        	if(typeof args.nome != 'undefined'){
        		this.paginator_core.url = 'gruppofoto/gruppoByNome?nome=' + args.nome;
        	}
        },

    });
    return GruppoFotoCollection;
});
