define([ 'backbone', 'resthub', 'jssor-slider', 'hbs!template/azienda' ],
		function(Backbone, Resthub, JssorSlider, aziendaTemplate) {

			var AziendaView = Resthub.View.extend({

				// Define view template
				template : aziendaTemplate,

				initialize : function() {

					// Render the view
					this.render();
				},

				render : function() {
					AziendaView.__super__.render.apply(this, arguments);
					var options = {
			                $AutoPlay: false,                                   //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
			                $SlideDuration: 500,                                //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
			                $DragOrientation: 3,
			                $BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
			                    $Class: $JssorBulletNavigator$,                       //[Required] Class to create navigator instance
			                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
			                    $AutoCenter: 1,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
			                    $Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
			                    $Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
			                    $SpacingX: 10,                                  //[Optional] Horizontal space between each item in pixel, default value is 0
			                    $SpacingY: 10,                                  //[Optional] Vertical space between each item in pixel, default value is 0
			                    $Orientation: 1                                 //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
			                },
			                $ArrowNavigatorOptions: {                       //[Optional] Options to specify and enable arrow navigator or not
			                    $Class: $JssorArrowNavigator$,              //[Requried] Class to create arrow navigator instance
			                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
			                    $AutoCenter: 0,                                 //[Optional] Auto center arrows in parent container, 0 No, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
			                    $Steps: 1                                       //[Optional] Steps to go for each navigation request, default value is 1
			                }
			            };
					var jssor_slider1 = new $JssorSlider$("slider1_container", options);
				},

			});
			return AziendaView;
		});