document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('taskForm') as HTMLFormElement;
    const submitBtn = document.getElementById('submitBtn') as HTMLButtonElement;

    submitBtn.addEventListener('click', async () => {
        const id = (document.getElementById('id') as HTMLInputElement).value;
        const title = (document.getElementById('title') as HTMLInputElement).value;
        const description = (document.getElementById('description') as HTMLInputElement).value;
        const assignTo = (document.getElementById('assignTo') as HTMLInputElement).value;

        const newTask = {
            id,
            title,
            description,
            assignTo
        };

        try {
            const response = await fetch('/_apis/CreateTask', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newTask)
            });

            if (response.ok) {
                const responseData = await response.json();
                console.log('Task created:', responseData);
                window.alert('Task created');
            } else {
                console.error('Error creating task:', response.status);
                window.alert('Error creating task:' + '\n' +response.status);
            }
        } catch (error) {
            console.error('Error creating task:', error);
            window.alert('Error creating task' + '\n' +error);
        }
    });
});
