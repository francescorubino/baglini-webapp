define([ 'backbone', 'resthub', 'hbs!template/paginator', 'model/paginator' ], function(Backbone,
		Resthub, paginatorTemplate, PaginatorModel) {

	var PaginatorView = Resthub.View.extend({

		// Define view template
		template : paginatorTemplate,

		initialize : function(args) {
			
			this.model = new PaginatorModel({
				totalPages: args.totalPages,
				currentPage: args.currentPage
			});

			this.render();
//			this.listenTo(this.model, 'sync', this.render);
		}

	});
	return PaginatorView;
});