define([ 'backbone', 'resthub', 'collection/notizia-collection',
		'hbs!template/news' ], function(Backbone, Resthub, NotiziaCollection,
		newsTemplate) {

	var NewsView = Resthub.View.extend({

		// Define view template
		template : newsTemplate,

		initialize : function(args) {

			// Initialize the collection
			
			this.collection = new NotiziaCollection({
					anno : args.anno,
					mese : args.mese					
			});

			// Render the view when the collection is retreived from the server
			this.listenTo(this.collection, 'sync', this.render);

			// Request unpaginated URL
			this.collection.fetch({
				data : {
					page : 'no'
				}
			});
		},
		
		reset : function() {
			
		}

	});
	return NewsView;
});