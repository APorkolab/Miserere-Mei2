import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NpcDialogueComponent } from './npc-dialogue.component';

describe('NpcDialogueComponent', () => {
  let component: NpcDialogueComponent;
  let fixture: ComponentFixture<NpcDialogueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NpcDialogueComponent]
    });
    fixture = TestBed.createComponent(NpcDialogueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
