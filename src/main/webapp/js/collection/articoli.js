define(['backbone', 'model/articolo'], function (Backbone, Articolo) {

    var Articoli = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: Articolo,
        url:'articolo/list'

    });
    return Articoli;
});
