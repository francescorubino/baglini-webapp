define(['backbone', 'view/home-view', 'view/azienda-view', 'view/news-view', 'view/servizi-view', 'view/realizzazioni-view', 'view/proposte-view'],
function (Backbone, HomeView, AziendaView, NewsView, ServiziView, RealizzazioniView, ProposteView) {
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
            Backbone.history.start({ pushState: false, root: "/" });
        },
        
        routes:{
            '': 'home',
            'home' : 'home',
            'azienda': 'azienda',
            'news': 'news',
            'servizi': 'servizi',
            'realizzazioni' : 'realizzazioni',
            'proposte' : 'proposte',
            'it' : 'it',
            'en' : 'en'
        },

        home:function () {
            new HomeView({ root: $('#main') });
        },
        azienda:function () {
            new AziendaView({ root: $('#main') });     
        },
        servizi:function () {
        	new ServiziView({ root: $('#main') });     
        },
        realizzazioni:function () {
        	new RealizzazioniView({ root: $('#main') });     
        },
        proposte:function () {
        	new ProposteView({ root: $('#main') });     
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