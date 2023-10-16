import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoryLogComponent } from './story-log.component';

describe('StoryLogComponent', () => {
  let component: StoryLogComponent;
  let fixture: ComponentFixture<StoryLogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StoryLogComponent]
    });
    fixture = TestBed.createComponent(StoryLogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
