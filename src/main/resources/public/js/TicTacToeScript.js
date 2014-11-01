$(document).ready(function() {
  play_game();
  clear_board();
  
  $("#board").on("click", "td", function( event ) {
    var cell_id = $(this).attr('id');
    if ($(this).html() === "") {
      $.ajax({
          type: "post",
          url: "/id",
          data: "id=" + cell_id
      }).done(function(result) {
          if (result === "X" || result === "O") {
              $("#" + cell_id).html(result);
              is_game_over();
          } else {
              $("#displayWinner").html(result);
          }
      });
      event.preventDefault();
    };
  });

  $("#newGame").on("click", function() {
    play_game();
  });

});

function play_game() {
  $.ajax({
      type: "post",
      url: "/playGame",
  }).done(function(result) {
      if(result) {
          clear_board();
      }
  });
}

function clear_board(){
  for(var i = 1; i < 10; i++){
    $("#" + i).html("");
  }
  $("#displayWinner").html("");
}

function is_game_over() {
  $.ajax({
      type: "post",
      url: "/gameOver",
  }).done(function(result) {
      if(result === "") {

      } else {
        $("#displayWinner").html(result);
      }
  });
}