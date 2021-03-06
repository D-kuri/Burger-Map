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
    burgerKingMarkers = [];

    let burgerKingLocations = await getBurgerKingLocations();
    saveInfo(burgerKingLocations.burgerKing, burgerKingPositions, burgerKingMarkers, [5, 72]);
}

function setBurgerKingClusterer(){
    let burgerKingScore = document.getElementsByClassName('burgerKing_score')

    clusterer.clear();
    for (let i=0 ; i<parseInt(burgerKingScore[0].innerHTML) ; i++){
        createBurgerKingMarkers().then(() => {
            clusterer.addMarkers(burgerKingMarkers)
        });
    }
}

function setBurgerKingMarkers(){
    momsTouch.className = '';
    burgerKing.className = 'menu_selected';
    lotteria.className = '';
    mcDonalds.className = '';

    setBurgerKingClusterer();
}

function showBurgerKingScore(){
    burgerKing_score.style.display = "block";
    momsTouch_score.style.display = "none";
    lotteria_score.style.display = "none";
    mcDonalds_score.style.display = "none";
}

function changeBurgerKingScore(score){
    burgerKing_five.className = '';
    burgerKing_four.className = '';
    burgerKing_three.className = '';
    burgerKing_two.className = '';
    burgerKing_one.className = '';

    score.className = 'burgerKing_score';

    setBurgerKingClusterer();
}


