let momsTouchPositions = [];
let momsTouchMarkers = [];

function getMomsTouchLocations() {
    return $.ajax({
        url: "/map/momsTouch.json",
        type: "POST",
        success: (res => {return res;})
    })
}

async function createMomsTouchMarkers(){
    let momsTouchLocations = await getMomsTouchLocations();
    // console.log(momsTouchLocations);
    saveInfo(momsTouchLocations.momsTouch, momsTouchPositions, momsTouchMarkers, [5, 36]);
    // console.log(momsTouchPositions)
    // console.log(momsTouchMarkers)
}

function setMomsTouchMarkers(){
    momsTouch.className = 'menu_selected';
    burgerKing.className = '';
    mcDonalds.className = '';
    lotteria.className = '';

    clusterer.clear();
    clusterer.addMarkers(momsTouchMarkers);
}

createMomsTouchMarkers();