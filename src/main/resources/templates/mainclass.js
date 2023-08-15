document.getElementById('showLectureButton').addEventListener('click', function() {
    // 새 창에서 강의 내용을 보여주도록 설정
    window.open('https://www.youtube.com/watch?v=o6PBoeYKsVo&pp=ygUn7Ja066W07Iug65Ok7J2EIOychO2VnCDsnbjthLDrhLcg6rWQ7Jyh', '_blank', 'width=800,height=600');
  });
  
  document.getElementById('showQuestionButton').addEventListener('click', function() {
    document.getElementById('popup').style.display = 'block';
  });
  
  document.getElementById('closePopup').addEventListener('click', function() {
    document.getElementById('popup').style.display = 'none';
  });
  
  document.getElementById('submitQuestion').addEventListener('click', function() {
    const question = document.getElementById('questionTextarea').value;
    // 질문 처리 또는 제출
    document.getElementById('popup').style.display = 'none';
  });
  
  document.getElementById('showQuestionBoardButton').addEventListener('click', function() {
    window.location.href = 'ask.html'; // 페이지 이동
  });