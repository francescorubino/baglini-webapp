define([ 'backbone', 'resthub', 'jssor-slider', 'hbs!template/azienda'],
function (Backbone, Resthub, JssorSlider, aziendaTemplate) {
    
    var AziendaView = Resthub.View.extend({
        
        // Define view template
        template: aziendaTemplate,
        
        initialize:function () {

            // Render the view
            this.render();
        }

    });
    return AziendaView;
});