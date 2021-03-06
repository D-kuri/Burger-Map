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
    momsTouchMarkers = [];
    let momsTouchLocations = await getMomsTouchLocations();

    saveInfo(momsTouchLocations.momsTouch, momsTouchPositions, momsTouchMarkers, [5, 36]);
}

function setMomsTouchClusterer(){
    let momsTouchScore = document.getElementsByClassName('momsTouch_score')

    clusterer.clear();
    for (let i=0 ; i<parseInt(momsTouchScore[0].innerHTML) ; i++){
        createMomsTouchMarkers().then(() => {
            clusterer.addMarkers(momsTouchMarkers)
        });
    }
}

function setMomsTouchMarkers(){
    momsTouch.className = 'menu_selected';
    burgerKing.className = '';
    mcDonalds.className = '';
    lotteria.className = '';

    setMomsTouchClusterer();
}

function showMomsTouchScore(){
    burgerKing_score.style.display = "none";
    momsTouch_score.style.display = "block";
    lotteria_score.style.display = "none";
    mcDonalds_score.style.display = "none";
}

function changeMomsTouchScore(score){
    momsTouch_five.className = '';
    momsTouch_four.className = '';
    momsTouch_three.className = '';
    momsTouch_two.className = '';
    momsTouch_one.className = '';

    score.className = 'momsTouch_score';

    setMomsTouchClusterer();
}

