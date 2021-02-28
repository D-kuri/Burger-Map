const markerImageSrc = '/image/css_sprites.png';

let mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(35.231626, 129.084461), // 지도의 중심좌표
        level: 5
    };
let map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

let clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10 // 클러스터 할 최소 지도 레벨
});

function createMarkerImage(src, size, options) {
    let markerImage = new kakao.maps.MarkerImage(src, size, options);
    return markerImage;
}

function createMarker(position, image) {
    let marker = new kakao.maps.Marker({
        position: position,
        image: image
    });

    return marker;
}



let momsTouchPositions = [];
let momsTouchMarkers = [];

function getMomsTouchLocations() {
    return $.ajax({
        url: "/map/momsTouch.json",
        type: "POST",
        success: (res => {return res;})
    })
}

function saveInfo(burger, positions, markers) {
    burger.forEach(burgerLocation => {
        let location = new kakao.maps.LatLng(burgerLocation.longitude, burgerLocation.latitude);
        positions.push(location);

        let imageSize = new kakao.maps.Size(36, 40);
        let imageOptions = {
                spriteOrigin: new kakao.maps.Point(5, 36), // 5, 72
                spriteSize: new kakao.maps.Size(95, 116) // 95, 116
            };

        let markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions);
        let marker = createMarker(location, markerImage);

        markers.push(marker);
    })

}

async function createMomsTouchMarkers(){
    let momsTouchLocations = await getMomsTouchLocations();
    console.log(momsTouchLocations);
    saveInfo(momsTouchLocations.momsTouch, momsTouchPositions, momsTouchMarkers);
    console.log(momsTouchPositions)
    console.log(momsTouchMarkers)
    // setMomsTouchMarkers(map);

}

function setMomsTouchMarkers(map){
    clusterer.addMarkers(momsTouchMarkers);
    // for (let i = 0; i < momsTouchMarkers.length; i++) {
    //     clusterer.addMarkers(momsTouchMarkers[i]);
    //     // momsTouchMarkers[i].setMap(map);
    // }
}

createMomsTouchMarkers();

changeMarker('momsTouch');

function changeMarker(type){

    let momsTouch = document.getElementById('momsTouch');

    if (type === 'momsTouch'){
        momsTouch.className = 'menu_selected';

        // burgerKing.className = '';
        // mcdonald.className = '';
        // lotteria.className = '';
        console.log(momsTouchPositions);
        console.log(momsTouchMarkers);

        setMomsTouchMarkers(map);
        // setBurgerKing(null);
        // setMcdonald(null);
        // setLotteria(null);
    }
}