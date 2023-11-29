
var map;

console.log('itemList:', list);


function loadMapScenario() {
    map = new Microsoft.Maps.Map(document.getElementById('map'), {
        center: new Microsoft.Maps.Location(0, 0),
        zoom: 2
    });
    // Make AJAX request to your Spring Boot backend to get coordinates
    // and add markers to the map accordingly.
    addFlightPins();
}
function addFlightPins() {
    // Generate random coordinates for demonstration
    console.log(list)
    list.forEach((element) => {
        if (element.liveData) {
            var location = new Microsoft.Maps.Location(element.liveData.latitude, element.liveData.longitude);


            var img = new Image();
            img.src = '/airplane.png';
            img.onload = function () {
                var c = document.createElement('canvas');

                var rotationAngleRads = (element.liveData.direction-45)*Math.PI/180;

                c.width = 32
                c.height = 32

                var context = c.getContext('2d');


                context.translate(c.width / 2, c.height / 2);

                context.rotate(rotationAngleRads);

                context.drawImage(img, -img.width / 2, -img.height / 2);


                var pin = new Microsoft.Maps.Pushpin(location, {
                    icon: c.toDataURL(),
                    title: 'Flight ' + (element.number),
                    subTitle: 'Going to ' + element.arrival.airport,
                    anchor: new Microsoft.Maps.Point(0, 0),
                });



                Microsoft.Maps.Events.addHandler(pin, 'click', function (e) {
                    alert('Information about Aircraft\n' +
                        'Registration number: ' + element.aircraftData.registration + '\n' +
                        'Aircraft iata: ' + element.aircraftData.iata  + '\n' +
                        'Aircraft icao: ' + element.aircraftData.icao);
                });


                map.entities.push(pin);
            }
        }
    });
}
