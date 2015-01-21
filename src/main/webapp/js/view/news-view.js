define([ 'backbone', 'resthub', 'collection/notizie', 'hbs!template/news' ],
function (Backbone, Resthub, Notizie, newsTemplate) {
    
    var NewsView = Resthub.View.extend({
        
        // Define view template
        template: newsTemplate,

        initialize:function () {
            // Initialize the collection
            this.collection = new Notizie();
            
            // Render the view when the collection is retreived from the server
            this.listenTo(this.collection, 'sync', this.render);
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} });
        }

    });
    return NewsView;
});