define(['backbone', 'model/notizia'], function (Backbone, Notizia) {

    var Notizie = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: Notizia,
        url:'notizie/list'

    });
    return Notizie;
});
