var app = new Vue({
    el: '#app',
    data: function() {
    return {
        image1: 'images/01.jpg',
        image2: 'images/03.PNG',
        image3: 'images/05.jpg',
        image4: 'images/07.jpg',
        title: 'Vue - Images Show/Hide',
        show: true
    }
}, 

methods: {
    mouseover1: function() {
        this.image1 = 'images/02.jpg'
    },
    mouseout1: function() {
        this.image1 = "images/01.jpg"
    },
    mouseover2: function() {
        this.image2 = 'images/04.PNG'
    },
    mouseout2: function() {
        this.image2 = "images/03.PNG"
    },
    mouseover3: function() {
        this.image3 = 'images/06.jpg'
    },
    mouseout3: function() {
        this.image3 = "images/05.jpg"
    },
    mouseover4: function() {
        this.image4 = 'images/08.jpg'
    },
    mouseout4: function() {
        this.image4 = "images/07.jpg"
    }
}
})