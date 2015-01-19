define(['backbone', 'view/azienda-view'],
function (Backbone, AziendaView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
            Backbone.history.start({ pushState: false, root: "/" });
        },

        routes:{
            '': 'home',
            'azienda': 'azienda'
        },

        home:function () {
//            new SamplesView({ root: $('#main') });
        },
        azienda:function () {
            new AziendaView({ root: $('#main') });      }

    });

    return AppRouter;

});