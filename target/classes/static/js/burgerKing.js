let burgerKingPositions = [];
let burgerKingMarkers = [];

function getBurgerKingLocations() {
    return $.ajax({
        url: "/map/burgerKing.json",
        type: "POST",
        success: (res => {return res;})
    })
}

async function createBurgerKingMarkers(){
    let burgerKingLocations = await getBurgerKingLocations();
    saveInfo(burgerKingLocations.burgerKing, burgerKingPositions, burgerKingMarkers, [5, 72]);

    setBurgerKingMarkers(map);
}

function setBurgerKingMarkers(){
    momsTouch.className = '';
    burgerKing.className = 'menu_selected';
    lotteria.className = '';
    mcDonalds.className = '';

    clusterer.clear();
    clusterer.addMarkers(burgerKingMarkers);
}

createBurgerKingMarkers();
