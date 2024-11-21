// 삭제 기능
const deleteButton = document.getElementById('delete-btn');

if (deleteButton != null) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch('/api/articles/' + id, {
            method: 'DELETE'
        })
            .then((response) => {
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
            });
    });
}

// 수정 기능
const modifyButton = document.getElementById('modify-btn');

if (modifyButton != null) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch('/api/articles/' + id, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then((response) => {
                alert('수정이 완료되었습니다.');
                location.replace('/articles/' + id);
            });
    });
}

// 생성 기능
const createButton = document.getElementById('create-btn');

if (createButton != null) {
    createButton.addEventListener('click', event => {
        fetch('/api/articles', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then((response) => {
                alert('등록 완료되었습니다.');
                location.replace('/articles');
            });
    });
}
