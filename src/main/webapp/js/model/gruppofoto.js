define(['backbone'], function(Backbone) {
    var GruppoFotoModel = Backbone.Model.extend({

    	url : "gruppofoto",
        
        initialize: function(args){
        	if(typeof args.url != 'undefined'){
        		this.url = args.url;
        	}
        	if(typeof args.name != 'undefined'){
        		this.url += "/gruppoByNome?nome=" + args.name;
        	}
        },
        

    });
    return GruppoFotoModel;
});