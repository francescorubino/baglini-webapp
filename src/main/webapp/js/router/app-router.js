define(['backbone', 'view/home-view', 'view/azienda-view', 'view/news-view'],
function (Backbone, HomeView, AziendaView, NewsView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
            Backbone.history.start({ pushState: false, root: "/" });
        },

        routes:{
            '': 'home',
            'home' : 'home',
            'azienda': 'azienda',
            'servizi': 'servizi'
        },

        home:function () {
            new HomeView({ root: $('#main') });
        },
        azienda:function () {
            new AziendaView({ root: $('#main') });     
        },
        servizi:function () {
            new NewsView({ root: $('#main') });      
        }

    });

    return AppRouter;

});