jQuery(document).ready(function($) {

	'use strict';
    //***************************
    // Sticky Header Function
    //***************************
	  jQuery(window).scroll(function() {
	      if (jQuery(this).scrollTop() > 170){  
	          jQuery('body').addClass("sportsmagazine-sticky");
	      }
	      else{
	          jQuery('body').removeClass("sportsmagazine-sticky");
	      }
	  });

    //***************************
    // BannerOne Functions
    //***************************
      jQuery('.sportsmagazine-banner-one').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 2000,
          infinite: true,
          dots: false,
          arrows: false,
          fade: true,
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    infinite: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
              ]
        });
    //***************************
    // fixtureSlider Functions
    //***************************
      jQuery('.sportsmagazine-fixture-slider').slick({
          slidesToShow: 6,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 2000,
          infinite: true,
          dots: false,
          prevArrow: "<span class='slick-arrow-left'><i class='fa fa-angle-left'></i></span>",
          nextArrow: "<span class='slick-arrow-right'><i class='fa fa-angle-right'></i></span>",
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1,
                    infinite: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
              ]
        });
    //***************************
    // FeaturedSlider Functions
    //***************************
      jQuery('.sportsmagazine-featured-slider').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 2000,
          infinite: true,
          dots: false,
          prevArrow: "<span class='slick-arrow-left'><i class='fa fa-angle-left'></i></span>",
          nextArrow: "<span class='slick-arrow-right'><i class='fa fa-angle-right'></i></span>",
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    infinite: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
              ]
        });

    //***************************
    // ThumbSlider Functions
    //***************************
    jQuery('.sportsmagazine-player-slider-image').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          arrows: false,
          fade: true,
          autoplay: true,
          autoplaySpeed: 2000,
          asNavFor: '.sportsmagazine-player-slider-nav'
        });
        jQuery('.sportsmagazine-player-slider-nav').slick({
          slidesToShow: 4,
          slidesToScroll: 1,
          asNavFor: '.sportsmagazine-player-slider-image',
          dots: false,
          vertical: true,
          arrows: false,
          centerMode: false,
          autoplay: true,
          autoplaySpeed: 2000,
          focusOnSelect: true,
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 4,
                    slidesToScroll: 1,
                    infinite: true,
                    vertical: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 4,
                    slidesToScroll: 1,
                    vertical: true,
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    vertical: true,
                  }
                }
              ],
        });
    //***************************
    // BannerOne Functions
    //***************************
      jQuery('.sportsmagazine-ticker-slide').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 1000,
          infinite: true,
          dots: false,
          arrows: false,
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    infinite: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
              ]
        });
    //***************************
    // ThumbSlider Functions
    //***************************
    jQuery('.widget-images-thumb').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          arrows: false,
          fade: true,
          asNavFor: '.widget-images-list'
        });
        jQuery('.widget-images-list').slick({
          slidesToShow: 4,
          slidesToScroll: 1,
          asNavFor: '.widget-images-thumb',
          dots: false,
          vertical: false,
          prevArrow: "<span class='slick-arrow-left'><i class='fa fa-angle-left'></i></span>",
          nextArrow: "<span class='slick-arrow-right'><i class='fa fa-angle-right'></i></span>",
          centerMode: false,
          focusOnSelect: true,
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 4,
                    slidesToScroll: 1,
                    infinite: true,
                    vertical: false,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 5,
                    slidesToScroll: 1,
                    vertical: false,
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1,
                    vertical: false,
                  }
                }
              ],
        });
    //***************************
    // counter Functions
    //***************************
      jQuery('.counter-slider').slick({
          slidesToShow: 3,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 2000,
          infinite: true,
          dots: false,
          prevArrow: "<span class='slick-arrow-left'><i class='icon-arrows-2'></i></span>",
          nextArrow: "<span class='slick-arrow-right'><i class='icon-arrows-2'></i></span>",
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1,
                    infinite: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
              ]
        });
    //***************************
    // BannerTwo Functions
    //***************************
      jQuery('.sportsmagazine-banner-two').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 2000,
          infinite: true,
          dots: true,
          arrows: false,
          fade: true,
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    infinite: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
              ]
        });
    //***************************
    // PartnerSlider Functions
    //***************************
      jQuery('.sportsmagazine-partner-slider').slick({
          slidesToShow: 4,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 2000,
          infinite: true,
          dots: false,
          prevArrow: "<span class='slick-arrow-left'><i class='icon-arrows-2'></i></span>",
          nextArrow: "<span class='slick-arrow-right'><i class='icon-arrows-2'></i></span>",
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 3,
                    slidesToScroll: 1,
                    infinite: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 2,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
              ]
        });
    //***************************
    // Widget Awards Functions
    //***************************
      jQuery('.widget_awards').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 2000,
          infinite: true,
          dots: false,
          prevArrow: "<span class='slick-arrow-left'><i class='icon-arrows-2'></i></span>",
          nextArrow: "<span class='slick-arrow-right'><i class='icon-arrows-2'></i></span>",
          responsive: [
                {
                  breakpoint: 1024,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    infinite: true,
                  }
                },
                {
                  breakpoint: 800,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                },
                {
                  breakpoint: 400,
                  settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                  }
                }
              ]
        });

    //***************************
    // Click to Top Button
    //***************************
    jQuery('.sportsmagazine-back-top,.sportsmagazine-top-back').on("click", function() {
        jQuery('html, body').animate({
            scrollTop: 0
        }, 800);
        return false;
    });
    //***************************
    // Parent AddClass Function
    //***************************
    jQuery(".sportsmagazine-dropdown-menu,.sportsmagazine-megamenu").parent("li").addClass("subdropdown-addicon");

    //***************************
    // Fancybox Function
    //***************************
    jQuery(".fancybox").fancybox({
      openEffect  : 'elastic',
      closeEffect : 'elastic',
    });

    //***************************
    // Counter Function
    //***************************
    jQuery('#word-count1').jQuerySimpleCounter({
      end:3500,
      duration: 5000
    });
    jQuery('#word-count2').jQuerySimpleCounter({
      end:124,
      duration: 5000
    });
    jQuery('#word-count3').jQuerySimpleCounter({
      end:179,
      duration: 5000
    });
    jQuery('#word-count4').jQuerySimpleCounter({
      end:300,
      duration: 5000
    });
    
    // Masonry Functions
    jQuery('.grid').isotope({
      itemSelector: '.grid-item',
      percentPosition: true,
      masonry: {
        fitWidth: true
      }
    });
    //***************************
    // CartToggle Function
    //***************************
    jQuery('a.sportsmagazine-open-cart').on("click", function(){
          jQuery('.sportsmagazine-cart-box').slideToggle('slow');
          return false;
      });
      jQuery('html').on("click", function() { jQuery(".sportsmagazine-cart-box").fadeOut(); });

    //***************************
    // Progressbar Function
    //***************************
    jQuery('.progressbar1').progressBar({
      percentage : false,
      animation : true,
      backgroundColor : "#ececec",
      barColor : "#ffdc11",
      height : "12",
    });

    //***************************
    // Countdown Function
    //***************************
    jQuery(function() {
        var austDay = new Date();
        austDay = new Date(austDay.getFullYear() + 2, 1 - 1, -600);
        jQuery('#sportsmagazine-countdown,#sportsmagazine-game-countdown,#sportsmagazine-banner-countdown').countdown({
            until: austDay
        });
        jQuery('#year').text(austDay.getFullYear());
    });
    

});


//***************************
// Map Function
//***************************

// When the window has finished loading create our google map below
google.maps.event.addDomListener(window, 'load', init);

function init() {
    // Basic options for a simple Google Map
    // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
    var mapOptions = {
        // How zoomed in you want the map to start at (always required)
        zoom: 11,

        // The latitude and longitude to center the map (always required)
        center: new google.maps.LatLng(40.6700, -73.9400), // New York

        // How you would like to style the map. 
        // This is where you would paste any style found on Snazzy Maps.
        styles: [{"featureType":"road.highway","elementType":"labels","stylers":[{"hue":"#ffffff"},{"saturation":-100},{"lightness":100},{"visibility":"off"}]},{"featureType":"landscape.natural","elementType":"all","stylers":[{"hue":"#ffffff"},{"saturation":-100},{"lightness":100},{"visibility":"on"}]},{"featureType":"road","elementType":"all","stylers":[{"hue":"#ffe94f"},{"saturation":100},{"lightness":4},{"visibility":"on"}]},{"featureType":"road.highway","elementType":"geometry","stylers":[{"hue":"#ffe94f"},{"saturation":100},{"lightness":4},{"visibility":"on"}]},{"featureType":"water","elementType":"geometry","stylers":[{"hue":"#333333"},{"saturation":-100},{"lightness":-74},{"visibility":"off"}]}]
    };

    // Get the HTML DOM element that will contain your map 
    // We are using a div with id="map" seen below in the <body>
    var mapElement = document.getElementById('map');

    // Create the Google Map using our element and options defined above
    var map = new google.maps.Map(mapElement, mapOptions);

    // Let's also add a marker while we're at it
    var marker = new google.maps.Marker({
        position: new google.maps.LatLng(40.6700, -73.9400),
        map: map,
        title: 'Snazzy!'
    });
}