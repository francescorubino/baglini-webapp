define([ 'backbone' ], function(Backbone) {
	var PaginatorModel = Backbone.Model.extend({

		initialize : function(args) {

			this.totalPages = args.totalPages;
			this.currentPage = args.currentPage;

		}

	});
	return PaginatorModel;
});