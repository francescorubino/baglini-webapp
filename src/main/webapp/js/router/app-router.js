define(['backbone', 'view/home-view', 'view/azienda-view', 'view/news-view', 'view/servizi-view'],
function (Backbone, HomeView, AziendaView, NewsView, ServiziView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
            Backbone.history.start({ pushState: false, root: "/" });
        },

        routes:{
            '': 'home',
            'home' : 'home',
            'azienda': 'azienda',
            'servizi': 'servizi',
            'servizi': 'servizi',
        },

        home:function () {
            new HomeView({ root: $('#main') });
        },
        azienda:function () {
            new AziendaView({ root: $('#main') });     
        },
        servizi:function () {
            new NewsView({ root: $('#main') });      
        },
        servizi:function () {
        	new ServiziView({ root: $('#main') });     
        },

    });

    return AppRouter;

});