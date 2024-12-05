<?php

if (!function_exists('getFuelStatus')) {
    function getFuelStatus($value)
    {
        return match ($value) {
            1 => 'Disponible',
            2 => 'Sin Disponiblidad',
            3 => 'No a la venta',
            default => 'Sin información',
        };
    }
}
