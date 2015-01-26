define([ 'backbone', 'resthub', 'collection/gruppofoto-collection', 'hbs!template/gruppoFoto' ],
function (Backbone, Resthub, GruppoFotoCollection, gruppoFotoTemplate) {
    
    var GruppoFotoView = Resthub.View.extend({
        
        // Define view template
        template: gruppoFotoTemplate,

        initialize:function (args) {
            // Initialize the collection
            this.collection = new GruppoFotoCollection({
            	nomeSezione : args.nomeSezione
            });
            
            // Render the view when the collection is retreived from the server
            this.listenTo(this.collection, 'sync', this.render);
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} });
        }

    });
    return GruppoFotoView;
});