package com.Reyhan.frontend;

import.com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Vector;

public class Player {
    private Vector2 velocity;
    private float gravity;
    private float force;
    private float MaxVerticalSpeed;
    private Rectangle collider;
    private float width;
    private float height;
    private float baseSpeed;
    private float distanceTraeled;

}
