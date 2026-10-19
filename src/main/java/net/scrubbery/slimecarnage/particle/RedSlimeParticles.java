package net.scrubbery.slimecarnage.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class RedSlimeParticles extends TextureSheetParticle {
    protected RedSlimeParticles(ClientLevel level, double x, double y, double z, SpriteSet spriteSet,
                                   double xSpeed, double ySpeed, double zSpeed)
    {
        super(level, x, y - 0.2f, z, 0.0, 0.0, 0.0);
        this.setSpriteFromAge(spriteSet);
        this.friction = 0.96F;
        this.xd *= 0.1F;
        this.yd *= 0.1F;
        this.zd *= 0.1F;
        this.xd += xSpeed;
        this.yd += ySpeed;
        this.zd += zSpeed;
        this.setR(1f);
        this.setG(0.0f);
        this.setB(0.0f);
        this.quadSize *= 1.875F;
        this.lifetime = 10;
        this.hasPhysics = false;

    }

    public void setR(float rCo) {
        this.rCol = rCo;
    }
    public  void setG(float gCo) {
        this.gCol = gCo;
    }
    public void setB(float bCo) {
        this.bCol = bCo;
    }

    public float getR()
    {
        return this.rCol;
    }

    public float getG()
    {
        return this.gCol;
    }

    public float getB()
    {
        return this.bCol;
    }


    @Override
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet)
        {
            this.spriteSet = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed)
        {

            return new RedSlimeParticles(clientLevel, pX, pY, pZ, this.spriteSet, pXSpeed, pYSpeed, pZSpeed);
        }
    }
}