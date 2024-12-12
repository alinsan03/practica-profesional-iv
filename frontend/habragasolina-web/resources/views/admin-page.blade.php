@include('components.headerAdmin')
<body>
    <div class="container">
        <div class="admin-page">
            <br><br>
            <div class="label-group">
                <label for="label1">Usuario:</label>
                <label for="label1">Test</label>
            </div>
            <div class="label-group">
                <label for="label2">Estación de Gasolina:</label>
                <label class="id-gas-station" for="label">1</label>
            </div>
            <div class="label-group">
                <label for="dropdown">Tipo de Gasolina:</label>
                <select id="dropdown">
                    <option value="">Select an option:</option>
                    @foreach ($fueltypes as $fuel)
                        <option value="{{ $fuel['id'] }}">{{ $fuel['name'] }}</option>
                    @endforeach
                </select>
            </div>
            <div>
                <center>
                    <table>
                        <tr>
                            <td>
                                <div>
                                    <button class="available status-btn" data-status="1">Disponible</button>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <button class="notavailable status-btn" data-status="2">No disponible</button>
                                </div>
                            </td>
                            <td>
                                <div>
                                    <button class="notsale status-btn" data-status="3">No se vende</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </center>
            </div>
        </div>
    </div>
    <script>
        document.querySelectorAll('.status-btn').forEach(button => {
            button.addEventListener('click', () => {
                
                const idGasStation = document.querySelector('.id-gas-station').textContent;
                const idFuelType = document.getElementById('dropdown').value;
                const idStatus = button.getAttribute('data-status');

                console.log(idGasStation);
                if (!idFuelType) {
                    alert('Por favor selecciona un tipo de gasolina.');
                    return;
                }

                const postData = {
                    idGasStation: idGasStation,
                    idFuelType: idFuelType,
                    idStatus: idStatus
                };

                fetch('/admin-page', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'X-CSRF-TOKEN': document.querySelector('meta[name="csrf-token"]').content,
                    },
                    body: JSON.stringify(postData),
                })
                    .then(response => response.json())
                    .then(data => {
                        if (data.error) {
                            console.error(data.error);
                            alert('Error: ' + data.detalle);
                        } else {
                            alert(data.mensaje);
                        }
                    })
                    .catch(error => console.error('Error:', error));
             });
        });
    </script>
</body>
@include('components.footer')
