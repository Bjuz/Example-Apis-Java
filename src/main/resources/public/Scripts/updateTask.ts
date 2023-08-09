document.addEventListener('DOMContentLoaded', () => {
    const updateTaskForm = document.getElementById('updateTaskForm') as HTMLFormElement;

    updateTaskForm.addEventListener('submit', async (event) => {
        event.preventDefault();

        const taskId = (document.getElementById('id') as HTMLInputElement).value;
        const title = (document.getElementById('title') as HTMLInputElement).value;
        const description = (document.getElementById('description') as HTMLInputElement).value;
        const assignTo = (document.getElementById('assignTo') as HTMLInputElement).value;
        const newState = (document.getElementById('newState') as HTMLInputElement).value;

        const updatedTask = {
            id: Number(taskId),
            title: title,
            description: description,
            assignTo: assignTo,
            state: newState
        };

        try {
            const response = await fetch('/_apis/UpdateTask', {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(updatedTask)
            });

            if (response.ok) {
                console.log('Task updated successfully');
                window.alert('Task updated successfully');

            } else {
                console.error('Error creating task:', response.status);
                window.alert('Error creating task:' + '\n' +response.status);
            }
        } catch (error) {
            console.error('Error updating task:', error);
            window.alert('Error updating task' + '\n' +error);
        }
    });
});
