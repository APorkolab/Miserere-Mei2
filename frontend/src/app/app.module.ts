import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { PlayerStatsComponent } from './component/dashboard/player-stats/player-stats.component';
import { StoryLogComponent } from './component/dashboard/story-log/story-log.component';
import { NpcDialogueComponent } from './component/dashboard/npc-dialogue/npc-dialogue.component';
import { AchievementsComponent } from './component/dashboard/achievements/achievements.component';
import { AudioBookComponent } from './component/audio-book/audio-book.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    PlayerStatsComponent,
    StoryLogComponent,
    NpcDialogueComponent,
    AchievementsComponent,
    AudioBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
