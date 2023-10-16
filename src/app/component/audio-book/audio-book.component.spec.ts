import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AudioBookComponent } from './audio-book.component';

describe('AudioBookComponent', () => {
  let component: AudioBookComponent;
  let fixture: ComponentFixture<AudioBookComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AudioBookComponent]
    });
    fixture = TestBed.createComponent(AudioBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
