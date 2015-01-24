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
            'servizi': 'news',
            'servizi': 'servizi',
            'it' : 'it',
            'en' : 'en'
        },

        home:function () {
            new HomeView({ root: $('#main') });
        },
        azienda:function () {
            new AziendaView({ root: $('#main') });     
        },
        news:function () {
            new NewsView({ root: $('#main') });      
        },
        servizi:function () {
        	new ServiziView({ root: $('#main') });     
        },
        routes:{
            '': 'home',
            'home' : 'home',
            'azienda': 'azienda',
            'news': 'news',
            'servizi': 'servizi',
            'it' : 'it',
            'en' : 'en'
        },

        home:function () {
            new HomeView({ root: $('#main') });
        },
        azienda:function () {
            new AziendaView({ root: $('#main') });     
        },
        news:function () {
            new NewsView({ root: $('#main') });      
        },
        it:function () {
        	var locale = localStorage.getItem('locale');
            if(locale != 'it-it') {
                localStorage.setItem('locale', 'it-it');
                location.reload();
            }
        	     
        },
        en:function () {
        	var locale = localStorage.getItem('locale');
            if(locale != 'en-us') {
                localStorage.setItem('locale', 'en-us');
                location.reload();
            }
        },

    });

    return AppRouter;

});