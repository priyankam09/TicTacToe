$(document).ready(function() {
  play_game();
  
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
          } else {
              $("#scoreBoard").html(result);
          }
      });
      event.preventDefault();
    };
  });

  function play_game() {
    $.ajax({
        type: "post",
        url: "/playGame",
    }).done(function(result) {
        if(result) {
            alert("GamOver");
        }
    });
  }
});