define([ 'backbone', 'resthub', 'jssor-slider', 'hbs!template/azienda'],
function (Backbone, Resthub, JssorSlider, aziendaTemplate) {
    
    var AziendaView = Resthub.View.extend({
        
        // Define view template
        template: aziendaTemplate,
        
        initialize:function () {

            // Render the view
            this.render();
        },
        
        render: function() {
        	AziendaView.__super__.render.apply(this, arguments);
        	var options = {
        	         $DragOrientation: 3,
        	         //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)
        	     };
        	var jssor_slider1 = new $JssorSlider$("slider1_container", options);
          },

    });
    return AziendaView;
});